package com.zola.invoice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.zola.invoice.api.InvoiceApi;
import com.zola.invoice.api.dto.InvoiceDto;
import com.zola.invoice.api.filter.InvoiceFilter;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class InvoiceControllerTest {

	// test using invoiceClient so both client and controller can be tested at the
	// same time
	@Resource
	private InvoiceApi invoiceClient;

	@Test
	public void createAndSearchInvoices() {
		InvoiceDto invoiceDto = new InvoiceDto.InvoiceDtoBuilder().invoiceNumber("in01").poNumber("po01")
				.amountCents(123L).dueDate(new Date()).build();
		// create the invoice
		CompletableFuture<InvoiceDto> responseInvoice = this.invoiceClient.createInvoice(invoiceDto);
		responseInvoice.thenApply(actual -> {
			assertTrue(actual.getId() > 0);
			assertEquals("in01", actual.getInvoiceNumber());
			assertEquals("po01", actual.getPoNumber());
			assertEquals("123", actual.getAmountCents().toString());
			return actual;
		});

		CompletableFuture<List<InvoiceDto>> responseInvoices = this.invoiceClient.searchInvoices(
				new InvoiceFilter.InvoiceFilterBuilder().invoiceNumber("in01").offset(0).limit(5).build());
		// find the invoice
		List<InvoiceDto> actual = new ArrayList<>();
		responseInvoices.thenApply(invoices -> actual.addAll(invoices));
		assertEquals(1, actual.size());
		assertTrue(actual.get(0).getId() > 0);
		assertEquals("in01", actual.get(0).getInvoiceNumber());
		assertEquals("po01", actual.get(0).getPoNumber());
		assertEquals("123", actual.get(0).getAmountCents().toString());
	}

	@Test
	public void createInvoiceMissingInvoiceNumber() {
		InvoiceDto invoiceDto = new InvoiceDto.InvoiceDtoBuilder().poNumber("po01").amountCents(123L)
				.dueDate(new Date()).build();
		// create the invoice
		try {
			this.invoiceClient.createInvoice(invoiceDto);
		} catch (HttpClientErrorException e) {
			assertTrue(e.getStatusCode().is4xxClientError());
		}
	}
}

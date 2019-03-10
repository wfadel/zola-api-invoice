package com.zola.invoice.client;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.zola.invoice.api.InvoiceApi;
import com.zola.invoice.api.dto.InvoiceDto;
import com.zola.invoice.api.filter.InvoiceFilter;

@Component
public class InvoiceClient implements InvoiceApi {
	@Resource
	private RestTemplate restTemplate;

	private static final String INVOICES_URI = "http://localhost:8080/v1/invoices";

	@Override
	public CompletableFuture<InvoiceDto> createInvoice(InvoiceDto invoiceDto) {
		ResponseEntity<InvoiceDto> response = restTemplate.postForEntity(INVOICES_URI, invoiceDto, InvoiceDto.class);
		return CompletableFuture.completedFuture(response.getBody());
	}

	@Override
	public CompletableFuture<List<InvoiceDto>> searchInvoices(InvoiceFilter invoiceFilter) {
		String filterUrl = String.format(INVOICES_URI + "?invoice_number=%s&po_number=%s&offset=%d&limit=%d",
				invoiceFilter.getInvoiceNumber(), invoiceFilter.getPoNumber(), invoiceFilter.getOffset(),
				invoiceFilter.getLimit());
		ResponseEntity<InvoiceDto[]> response = restTemplate.getForEntity(filterUrl, InvoiceDto[].class);
		return CompletableFuture.completedFuture(Arrays.asList(response.getBody()));
	}

}

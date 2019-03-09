package com.zola.invoice.rest.v1;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zola.invoice.api.InvoiceApi;
import com.zola.invoice.api.dto.InvoiceDto;
import com.zola.invoice.api.filter.InvoiceFilter;

@RestController("/v1/invoices")
public class InvoiceController {
	@Resource
	private InvoiceApi invoiceService;

	@PostMapping
	public CompletableFuture<ResponseEntity<InvoiceDto>> createInvoice(@RequestBody InvoiceDto invoiceDto) {
		return invoiceService.createInvoice(invoiceDto)
				.thenApply(result -> new ResponseEntity<>(result, HttpStatus.CREATED));
	}

	@GetMapping
	public CompletableFuture<ResponseEntity<List<InvoiceDto>>> searchInvoices(
			@RequestParam("invoiceNumber") String invoiceNumber, @RequestParam("poNumber") String poNumber,
			@RequestParam(name = "offset", defaultValue = "0") int offset,
			@RequestParam(name = "limit", defaultValue = "10") int limit) {
		InvoiceFilter invoiceFilter = new InvoiceFilter.InvoiceFilterBuilder().invoiceNumber(invoiceNumber)
				.poNumber(poNumber).offset(offset).limit(limit).build();
		return null;
	}

}

package com.zola.invoice.rest.v1;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zola.invoice.api.InvoiceApi;
import com.zola.invoice.api.dto.ErrorDto;
import com.zola.invoice.api.dto.InvoiceDto;
import com.zola.invoice.api.filter.InvoiceFilter;
import com.zola.invoice.exception.ZolaException;

@RestController("/v1/invoices")
public class InvoiceController {
	@Resource
	private InvoiceApi invoiceService;

	@PostMapping(consumes = "application/json", produces = "application/json")
	public CompletableFuture<ResponseEntity<InvoiceDto>> createInvoice(@RequestBody @Valid InvoiceDto invoiceDto) {
		return invoiceService.createInvoice(invoiceDto)
				.thenApply(result -> new ResponseEntity<>(result, HttpStatus.CREATED));
	}

	@GetMapping(produces = "application/json")
	public CompletableFuture<ResponseEntity<List<InvoiceDto>>> searchInvoices(
			@RequestParam(name = "invoice_number", required = false) String invoiceNumber,
			@RequestParam(name = "po_number", required = false) String poNumber,
			@RequestParam(name = "offset", defaultValue = "0") int offset,
			@RequestParam(name = "limit", defaultValue = "10") int limit) {
		InvoiceFilter invoiceFilter = new InvoiceFilter.InvoiceFilterBuilder().invoiceNumber(invoiceNumber)
				.poNumber(poNumber).offset(offset).limit(limit).build();
		return invoiceService.searchInvoices(invoiceFilter)
				.thenApply(result -> new ResponseEntity<>(result, HttpStatus.OK));
	}

	@ExceptionHandler(ZolaException.class)
	public ResponseEntity<ErrorDto> handleException(Throwable throwable) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorDto.ErrorDtoBuilder()
				.statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).message(throwable.getMessage()).build());
	}
}

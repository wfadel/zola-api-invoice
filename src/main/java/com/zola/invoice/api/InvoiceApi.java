package com.zola.invoice.api;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import com.zola.invoice.api.dto.InvoiceDto;
import com.zola.invoice.api.filter.InvoiceFilter;

public interface InvoiceApi {
	CompletableFuture<InvoiceDto> createInvoice(InvoiceDto invoiceDto);

	CompletableFuture<List<InvoiceDto>> searchInvoices(InvoiceFilter invoiceFilter);
}

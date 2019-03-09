package com.zola.invoice.api;

import java.util.List;

import com.zola.invoice.api.dto.InvoiceDto;
import com.zola.invoice.api.filter.InvoiceFilter;

public interface InvoiceApi {
	InvoiceDto createInvoice(InvoiceDto invoiceDto);
	List<InvoiceDto> searchInvoices(InvoiceFilter invoiceFilter);
}

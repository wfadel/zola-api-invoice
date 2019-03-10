package com.zola.invoice.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.annotation.Resource;

import org.springframework.core.convert.ConversionService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zola.invoice.api.InvoiceApi;
import com.zola.invoice.api.dto.InvoiceDto;
import com.zola.invoice.api.filter.InvoiceFilter;
import com.zola.invoice.repository.Invoice;
import com.zola.invoice.repository.InvoiceRepository;

@Service
public class InvoiceService implements InvoiceApi {
	@Resource
	private InvoiceRepository invoiceRepository;

	@Resource
	private ConversionService conversionService;

	@Async
	@Transactional
	@Override
	public CompletableFuture<InvoiceDto> createInvoice(InvoiceDto invoiceDto) {
		Invoice invoice = conversionService.convert(invoiceDto, Invoice.class);
		invoice = invoiceRepository.save(invoice);
		return CompletableFuture.completedFuture(conversionService.convert(invoice, InvoiceDto.class));
	}

	@Override
	public CompletableFuture<List<InvoiceDto>> searchInvoices(InvoiceFilter invoiceFilter) {
		// TODO Auto-generated method stub
		return null;
	}

}
package com.zola.invoice.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zola.invoice.api.InvoiceApi;
import com.zola.invoice.api.dto.InvoiceDto;
import com.zola.invoice.api.filter.InvoiceFilter;
import com.zola.invoice.exception.ZolaException;
import com.zola.invoice.repository.Invoice;
import com.zola.invoice.repository.InvoiceRepository;

@Service
public class InvoiceService implements InvoiceApi {
	private static final Logger LOGGER = LoggerFactory.getLogger(InvoiceService.class);

	@Resource
	private InvoiceRepository invoiceRepository;

	@Resource
	private ConversionService conversionService;

	@Async
	@Transactional
	@Override
	public CompletableFuture<InvoiceDto> createInvoice(InvoiceDto invoiceDto) {
		LOGGER.debug("Convert invoice dto with invoice_number {} and po_number {} to invoice",
				invoiceDto.getInvoiceNumber(), invoiceDto.getPoNumber());
		Invoice invoice = conversionService.convert(invoiceDto, Invoice.class);
		LOGGER.debug("Save invoice to database");
		try {
			invoice = invoiceRepository.save(invoice);
			return CompletableFuture.completedFuture(conversionService.convert(invoice, InvoiceDto.class));
		} catch (Exception e) {
			LOGGER.error("Failed to create invoice with invoice_number {} and po_number {}",
					invoiceDto.getInvoiceNumber(), invoiceDto.getPoNumber(), e);
			throw new ZolaException(e);
		}
	}

	@Async
	@Transactional
	@Override
	public CompletableFuture<List<InvoiceDto>> searchInvoices(InvoiceFilter invoiceFilter) {
		Page<Invoice> invoicePage = invoiceRepository.findByInvoiceNumberOrPoNumberOrderByCreatedAtDesc(
				invoiceFilter.getInvoiceNumber(), invoiceFilter.getPoNumber(),
				PageRequest.of(invoiceFilter.getOffset(), invoiceFilter.getLimit()));
		List<InvoiceDto> result = invoicePage.stream()
				.map(invoice -> conversionService.convert(invoice, InvoiceDto.class)).collect(Collectors.toList());
		return CompletableFuture.completedFuture(result);
	}

}

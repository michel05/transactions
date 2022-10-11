package com.devpass.challengehexagonal.controller

import com.devpass.challengehexagonal.controller.dto.TransactionRequestDto
import com.devpass.challengehexagonal.model.service.TransactionManagerService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("transaction")
class TransactionController(
    val transactionManagerService: TransactionManagerService
) {

    @GetMapping("/{clientId}")
    fun transactionForm(@PathVariable clientId: String, model: Model): String {
        model["clientId"] = clientId
        return "transaction-form"
    }

    @PostMapping
    fun postTransaction(transactionRequestDto: TransactionRequestDto): String {
        transactionManagerService.process(transactionRequestDto)
        return "redirect:"
    }
}
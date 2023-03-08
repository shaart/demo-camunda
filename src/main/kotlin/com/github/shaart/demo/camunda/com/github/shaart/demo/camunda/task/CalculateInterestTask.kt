package com.github.shaart.demo.camunda.com.github.shaart.demo.camunda.task

import com.github.shaart.demo.camunda.logger
import org.camunda.bpm.engine.delegate.DelegateExecution
import org.camunda.bpm.engine.delegate.JavaDelegate
import org.springframework.stereotype.Component

@Component
class CalculateInterestTask: JavaDelegate {

    private val log = logger()
    override fun execute(execution: DelegateExecution?) {
        log.info("calculating interest of the loan")
    }
}
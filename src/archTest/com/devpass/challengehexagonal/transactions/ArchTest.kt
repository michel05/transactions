package com.devpass.challengehexagonal.transactions

import com.tngtech.archunit.core.importer.ClassFileImporter
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses
import org.junit.jupiter.api.Test

class ArchTest {

    private val classesToCheck = ClassFileImporter().importClasspath()

    @Test
    fun `Nothing on domain should depend on resources`() {
        noClasses().that().resideInAPackage("..domain..")
            .should().dependOnClassesThat().resideInAPackage("..resources..")
            .allowEmptyShould(true)
            .check(classesToCheck)
    }

    @Test
    fun `Nothing on domain should depend on application`() {
        noClasses().that().resideInAPackage("..domain..")
            .should().dependOnClassesThat().resideInAPackage("..application..")
            .allowEmptyShould(true)
            .check(classesToCheck)
    }

    @Test
    fun `Nothing on application should depend on resources`() {
        noClasses().that().resideInAPackage("..application..")
            .should().dependOnClassesThat().resideInAPackage("..resources..")
            .allowEmptyShould(true)
            .check(classesToCheck)
    }

    @Test
    fun `Nothing on resources should depend on application`() {
        noClasses().that().resideInAPackage("..resources..")
            .should().dependOnClassesThat().resideInAPackage("..application..")
            .allowEmptyShould(true)
            .check(classesToCheck)
    }
}

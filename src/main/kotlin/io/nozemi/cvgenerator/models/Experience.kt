package io.nozemi.cvgenerator.models

import java.text.DateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class Experience(
    val title: String,
    val startDate: String,
    val endDate: String? = null,
    val description: String? = null,
    val employer: String,
    val employerUrl: String? = null
) {
    private val dateFormatter = DateTimeFormatter.ofPattern("LLL yyyy")

    override fun toString(): String {
        val processedEmployer = if (employerUrl != null) {
            "<a href='$employerUrl'>$employer</a>"
        } else "<span>$employer</span>"

        return """
            <div class='experience-item'>
                <div class='title'>$title</div>
                <div class='where'>@ $processedEmployer</div>
                <div class='time'>
                    ${LocalDate.parse(startDate).format(dateFormatter)} - 
                    ${if (endDate != null) LocalDate.parse(endDate).format(dateFormatter) else "Present"}</div>
                ${if (description != null) "<div class='description'>$description</div>" else ""}
            </div>
        """.trimIndent()
    }
}
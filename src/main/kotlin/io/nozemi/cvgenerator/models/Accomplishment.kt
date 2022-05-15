package io.nozemi.cvgenerator.models

data class Accomplishment(
    val description: String
) {
    override fun toString() = "<li>$description</li>"
}
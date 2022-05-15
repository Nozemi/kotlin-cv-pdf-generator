package io.nozemi.cvgenerator.models

data class Skill(
    val name: String,
    val url: String? = null
) {
    override fun toString(): String {
        val item = if (url != null)
            "<a href='$url'>$name</a>"
        else name

        return "<li>$item</li>"
    }
}
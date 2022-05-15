package io.nozemi.cvgenerator.models

data class Person(
    val profileImgUrl: String? = null,
    val firstname: String? = null,
    val lastname: String? = null,
    val title: String? = null,
    val birthDate: String? = null,
    val location: String? = null,
    val phone: String? = null,
    val email: String? = null,
    val about: String? = null,
    val profiles: Map<String, String> = mapOf(),
    val skills: List<Skill>? = null,
    val pastWork: List<Experience>? = null,
    val education: List<Experience>? = null,
    val accomplishments: List<Accomplishment>? = null
) {
    fun fullName() = "$firstname $lastname"
    fun emailAsLink() = "<a href='mailto:$email'>$email</a>"

    fun profileItemAsLink(key: String)
        = "<a href='https://${profiles[key]}'>${profiles[key]}</a>"
}
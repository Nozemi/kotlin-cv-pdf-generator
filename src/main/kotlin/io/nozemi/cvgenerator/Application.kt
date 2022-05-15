package io.nozemi.cvgenerator

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder
import java.io.FileOutputStream
import java.nio.file.Files
import java.time.*
import java.time.format.DateTimeFormatter
import kotlin.io.path.Path

fun main() {
    var content = Files.readString(Path("./data/templates/main.template.html"))

    val birthDayFormatter = DateTimeFormatter.ofPattern("LLL d, yyyy")

    val currentTime = LocalDateTime.now(ZoneId.ofOffset("UTC", ZoneOffset.UTC))
    val birthDate = LocalDateTime.parse(subject.birthDate ?: "1977-01-01T00:00:00.0000")

    val age = (Duration.between(
        birthDate,
        currentTime
    ).toDays() / 365.25).toInt()

    content = content.replace("{{SUBJECT_IMAGE_URL}}", subject.profileImgUrl ?: "N/A")
    content = content.replace("{{SUBJECT_FULL_NAME}}", subject.fullName())
    content = content.replace("{{SUBJECT_TITLE}}", subject.title ?: "N/A")

    content = content.replace("{{SUBJECT_AGE}}", "$age <small><i>(${birthDate.format(birthDayFormatter)})</i></small>")
    content = content.replace("{{SUBJECT_LOCATION}}", subject.location ?: "N/A")
    content = content.replace("{{SUBJECT_EMAIL}}", subject.emailAsLink())
    content = content.replace("{{SUBJECT_MOBILE}}", subject.phone ?: "N/A")

    content = content.replace("{{SUBJECT_WEBSITE}}", subject.profileItemAsLink("website"))
    content = content.replace("{{SUBJECT_LINKEDIN}}", subject.profileItemAsLink("linkedin"))
    content = content.replace("{{SUBJECT_GITHUB}}", subject.profileItemAsLink("github"))

    content = if (subject.about != null)
        content.replace("{{QUICK_INTRO}}", subject.about)
    else content.replace("{{QUICK_INTRO}}", "")

    content = content.replace("{{SKILLS}}", subject.skills?.joinToString("") ?: "No skills defined...")

    content = content.replace("{{WORK_EXPERIENCE}}", subject.pastWork?.joinToString("") ?: "No past work history...")
    content = content.replace("{{EDUCATIONAL_EXPERIENCE}}", subject.education?.joinToString("") ?: "No education history...")
    content = content.replace("{{ACCOMPLISHMENTS}}", subject.accomplishments?.joinToString("") ?: "No accomplishments...")

    Files.writeString(Path("./out.html"), content)

    FileOutputStream("./out.pdf").use {
        createPdfBuilder(content, it)
    }
}

fun createPdfBuilder(content: String, outStream: FileOutputStream) = PdfRendererBuilder().apply {
    useFastMode()

    withHtmlContent(content, "./data/")

    useFont(Path("./data/fonts/roboto/Roboto-Regular.ttf").toFile(), "Roboto")

    toStream(outStream)
    run()
}
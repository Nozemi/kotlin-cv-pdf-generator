package io.nozemi.cvgenerator

import io.nozemi.cvgenerator.models.Accomplishment
import io.nozemi.cvgenerator.models.Experience
import io.nozemi.cvgenerator.models.Person
import io.nozemi.cvgenerator.models.Skill

val subject = Person(
    profileImgUrl = "https://btmediaa.no/img/profile.jpg",
    firstname = "Bjørn-Tore",
    lastname = "Lastname",
    title = "System Engineer / IT Consultant",
    location = "Somewhere, Norway",
    birthDate = "1995-12-21T00:00:00.0000",
    email = "my@awesome.email",
    phone = "+47 999 99 999",
    profiles = mapOf(
        "website" to "nozemi.io/",
        "github" to "github.com/Nozemi",
        "linkedin" to "linkedin.com/in/btmediaa",
    ),
    skills = listOf(
        Skill(name = "Kotlin / Java"),
        Skill(name = "C# (ASP).NET (Core)"),
        Skill(name = "SQL &amp; SQL Databases"),
        Skill(name = "System Engineering"),
        Skill(name = "Fullstack Web Development"),
        Skill(name = "IT System Administration"),
        Skill(name = "IT Consulting / Support"),
    ),
    pastWork = listOf(
        Experience(
            title = "System Engineer",
            employer = "Something Inc.",
            employerUrl = "https://google.com/",
            startDate = "2019-08-01",
            endDate = "2021-03-31",
            description = """
                <p>
                    Development on the C# ASP.NET-based application.
                    <ul>
                        <li>C# (ASP).NET</li>
                        <li>Fullstack Web Development</li>
                    </ul>
                </p>
            """.trimIndent()
        ),
        Experience(
            title = "Fullstack Web Developer",
            employer = "Another Inc.",
            employerUrl = "https://google.com/",
            startDate = "2017-03-01",
            endDate = "2019-07-31",
            description = """
                <p>
                    Implementing customer websites on a proprietary PHP-based CMS solution.
                    <ul>
                        <li>PHP</li>
                        <li>Fullstack Web Development</li>
                    </ul>
                </p>
            """.trimIndent()
        ),
        Experience(
            title = "IT Consultant",
            employer = "Whatever Inc.",
            startDate = "2014-08-01",
            endDate = "2016-07-31",
            description = """
                <p>
                    Managing IT infrastructure at the company, such as student and teacher PCs, printers, and networking switches.
                    <ul>
                        <li>Windows</li>
                        <li>macOS</li>
                        <li>Networking</li>
                        <li>Windows Server</li>
                        <li>Active Directory</li>
                        <li>SCCM</li>
                        <li>User Support</li>
                    </ul>
                </p>
            """.trimIndent()
        )
    ),
    education = listOf(
        Experience(
            title = "Yr4 - High School Diploma",
            employer = "Whatever High School, City",
            startDate = "2016-08-01",
            endDate = "2017-06-30"
        ),
        Experience(
            title = "Yr2 - ICT Service Operations",
            employer = "Another High School, City",
            startDate = "2013-08-01",
            endDate = "2014-06-30"
        ),
        Experience(
            title = "Yr1 - Media &amp; Communication",
            employer = "Some High School, City",
            startDate = "2011-08-01",
            endDate = "2012-06-30"
        )
    ),
    accomplishments = listOf(
        Accomplishment("Various cool spare time projects, some I can show upon request, and some that are open source on my GitHub page."),
        Accomplishment("Implementing the website for <a href='https://exanoke.com/'>example.com</a> while working at Another Inc.")
    ),
    about = """
        <h2>Quick Introduction</h2>
        <hr/>
        
        <p>
            This is my quick introduction, so the employer or recruiter can get a quick idea of who I am,
            and why I'm suitable for whatever position they are looking to fill.
        </p>
        
        <p>You're welcome to reach out for more information!</p>
    """.trimIndent()
)
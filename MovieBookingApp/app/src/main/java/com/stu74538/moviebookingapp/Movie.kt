package com.stu74538.moviebookingapp

class Movie(
    val name: String,
    val image: String,
    val certification: String,
    val description: String,
    val starring: Array<String>,
    val runningTimeMins: Int,
    var seatsRemaining: Int,
    var seatsSelected: Int = 0
)

val movieArray = arrayOf(
    Movie(
        name = "DUNE: PART TWO",
        image = R.drawable.dune.toString(),
        certification = "12A",
        description = "Paul Atreides unites with Chani and the Fremen while on a warpath of revenge against the conspirators who destroyed his family. Facing a choice between the love of his life and the fate of the known universe, he endeavors to prevent a terrible future only he can foresee.",
        starring = arrayOf("Timothée Chalamet", "Florence Pugh", "Zendaya", "Souheila Yacoub", "Austin Butler"),
        runningTimeMins = 166,
        seatsRemaining = 5,
        seatsSelected = 2,
    ),
    Movie(
        name = "GHOSTBUSTERS: FROZEN EMPIRE",
        image = R.drawable.ghostbusters_poster.toString(),
        certification = "12A",
        description = "In Ghostbusters: Frozen Empire, the Spengler family returns to where it all started – the iconic New York City firehouse – to team up with the original Ghostbusters, who’ve developed a top-secret research lab to take busting ghosts to the next level. But when the discovery of an ancient artifact unleashes an evil force, Ghostbusters new and old must join forces to protect their home and save the world from a second Ice Age.",
        starring = arrayOf("Paul Rudd", "Bill Murray", "Finn Wolfhard", "Dan Aykroud", "Annie Potts", "Mckenna Grace", "Ernie Hudson"),
        runningTimeMins = 144,
        seatsRemaining = 4,
    ),
    Movie(
        name = "IMMACULATE",
        image = R.drawable.immaculate.toString(),
        certification = "16",
        description = "Sydney Sweeney stars as devout nun Cecilia, trapped in an ancient Italian convent that conceals twisted secrets and unspeakable horrors.\nCecilia, a woman of devout faith, is warmly welcomed to the picture-perfect Italian countryside where she is offered a new role at an illustrious convent. But it becomes clear to Cecilia that her new home harbors dark and horrifying secrets.",
        starring = arrayOf("Sydney Sweeney", "Benedetta Porcaroli", "Álvaro Morte", "Simona Tabasco"),
        runningTimeMins = 89,
        seatsRemaining = 6,
    ),
    Movie(
        name = "WICKED LITTLE LETTERS",
        image = R.drawable.wicked_little_letters.toString(),
        certification = "15A",
        description = "A 1920s English seaside town bears witness to a dark and absurd scandal in this riotous mystery comedy. Based on a stranger than fiction true story, WICKED LITTLE LETTERS follows two neighbours: deeply conservative local Edith Swan (Olivia Colman) and rowdy Irish migrant Rose Gooding (Jessie Buckley). When Edith and fellow residents begin to receive wicked letters full of unintentionally hilarious profanities, foulmouthed Rose is charged with the crime. The anonymous letters prompt a national uproar, and a trial ensues. However, as the town's women - led by Police Officer Gladys Moss (Anjana Vasan) - begin to investigate the crime themselves, they suspect that something is amiss, and Rose may not be the culprit after all.",
        starring = arrayOf("Olivia Colman", "Timothy Spall", "Eileen Atkins", "Gemma Jones", "Anjana Vasan", "Jessie Buckley"),
        runningTimeMins = 100,
        seatsRemaining = 10,
    ),
)
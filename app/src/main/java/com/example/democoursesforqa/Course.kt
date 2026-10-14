
package com.example.democoursesforqa

data class Course(
    val id: Int,
    val title: String,
    val category: String,
    val description: String,
    val price: Double,
    val lessons: List<String>,
    val imageUrl: String
)

object CourseData {

    val courses = listOf(
        Course(
            id = 1,
            title = "Programação com Kotlin",
            category = "Tecnologia",
            description = "Aprende os fundamentos de Kotlin e cria as tuas primeiras aplicações.",
            price = 49.90,
            lessons = listOf(
                "Introdução ao Kotlin",
                "Variáveis e tipos de dados",
                "Funções e classes",
                "Projeto prático"
            ),
            imageUrl = "https://images.unsplash.com/photo-1516321318423-f06f85e504b3?w=900"
        ),
        Course(
            id = 2,
            title = "Marketing Digital",
            category = "Marketing",
            description = "Descobre estratégias para divulgar marcas e produtos online.",
            price = 39.90,
            lessons = listOf(
                "Fundamentos do marketing",
                "Redes sociais",
                "Criação de conteúdo",
                "Planeamento de campanhas"
            ),
            imageUrl = "https://images.unsplash.com/photo-1460925895917-afdab827c52f?w=900"
        ),
        Course(
            id = 3,
            title = "Fotografia para Iniciantes",
            category = "Criatividade",
            description = "Aprende composição, iluminação e técnicas fotográficas.",
            price = 29.90,
            lessons = listOf(
                "Conhecer a câmara",
                "Composição fotográfica",
                "Luz e exposição",
                "Edição básica"
            ),
            imageUrl = "https://images.unsplash.com/photo-1452587925148-ce544e77e70d?w=900"
        ),
        Course(
            id = 4,
            title = "Finanças Pessoais",
            category = "Negócios",
            description = "Aprende a organizar o teu orçamento e definir objetivos financeiros.",
            price = 34.90,
            lessons = listOf(
                "Organização do orçamento",
                "Receitas e despesas",
                "Objetivos financeiros",
                "Planeamento mensal"
            ),
            imageUrl = "https://images.unsplash.com/photo-1554224155-6726b3ff858f?w=900"
        )
    )
}
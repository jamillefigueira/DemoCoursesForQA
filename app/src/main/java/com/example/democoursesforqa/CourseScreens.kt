

package com.example.democoursesforqa

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.layout.ContentScale
import coil.compose.AsyncImage
import java.text.NumberFormat
import java.util.Locale

private enum class CoursePage {
    CATALOG, DETAILS, CART
}

@Composable
fun CourseCatalogScreen() {
    var currentPage by remember { mutableStateOf(CoursePage.CATALOG) }
    var selectedCourse by remember { mutableStateOf<Course?>(null) }
    var cartCourses by remember { mutableStateOf(listOf<Course>()) }
    var message by remember { mutableStateOf("") }

    Scaffold(
        contentWindowInsets = androidx.compose.foundation.layout.WindowInsets.safeDrawing,
        topBar = {
            Row(
                modifier = Modifier
                    .statusBarsPadding()
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(

                    text = "Demo Courses",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )

                TextButton(onClick = {
                    currentPage = CoursePage.CART
                    message = ""
                }) {
                    Text("Carrinho (${cartCourses.size})")
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            if (message.isNotBlank()) {
                Text(
                    text = message,
                    modifier = Modifier.padding(horizontal = 16.dp),
                    color = MaterialTheme.colorScheme.primary
                )
            }

            when (currentPage) {
                CoursePage.CATALOG -> {
                    LazyColumn(
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        item {
                            Text(
                                "Explora os nossos cursos online.",
                                style = MaterialTheme.typography.titleMedium
                            )
                        }

                        items(CourseData.courses) { course ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        selectedCourse = course
                                        currentPage = CoursePage.DETAILS
                                        message = ""
                                    }
                            ) {
                                Column {
                                    AsyncImage(
                                        model = course.imageUrl,
                                        contentDescription = course.title,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(170.dp),
                                        contentScale = ContentScale.Crop
                                    )

                                    Column(Modifier.padding(16.dp)) {
                                        Text(
                                            course.category,
                                            color = MaterialTheme.colorScheme.primary
                                        )
                                        Text(
                                            course.title,
                                            style = MaterialTheme.typography.titleLarge,
                                            fontWeight = FontWeight.Bold
                                        )
                                        Text(formatCoursePrice(course.price))
                                        Spacer(Modifier.height(8.dp))
                                        Text("Toca para ver os detalhes")
                                    }
                                }
                            }
                        }
                    }
                }

                CoursePage.DETAILS -> {
                    val course = selectedCourse

                    if (course != null) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        ) {
                            TextButton(onClick = {
                                currentPage = CoursePage.CATALOG
                                message = ""
                            }) {
                                Text("← Voltar ao catálogo")
                            }

                            LazyColumn(
                                modifier = Modifier.weight(1f)
                            ) {
                                item {
                                    AsyncImage(
                                        model = course.imageUrl,
                                        contentDescription = course.title,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(210.dp),
                                        contentScale = ContentScale.Crop
                                    )

                                    Spacer(Modifier.height(16.dp))

                                    Text(
                                        course.category,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                    Text(
                                        course.title,
                                        style = MaterialTheme.typography.headlineSmall,
                                        fontWeight = FontWeight.Bold
                                    )

                                    Spacer(Modifier.height(8.dp))
                                    Text(course.description)

                                    Spacer(Modifier.height(16.dp))
                                    Text(
                                        "Preço: ${formatCoursePrice(course.price)}",
                                        style = MaterialTheme.typography.titleLarge,
                                        fontWeight = FontWeight.Bold
                                    )

                                    Spacer(Modifier.height(16.dp))
                                    Text(
                                        "Conteúdo do curso",
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold
                                    )

                                    course.lessons.forEachIndexed { index, lesson ->
                                        Text("${index + 1}. $lesson")
                                    }
                                }
                            }

                            Button(
                                onClick = {
                                    val alreadyInCart =
                                        cartCourses.any { it.id == course.id }

                                    if (alreadyInCart) {
                                        message = "Este curso já está no carrinho."
                                    } else {
                                        cartCourses = cartCourses + course
                                        message = "Curso adicionado ao carrinho!"
                                    }
                                },
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text("Adicionar ao carrinho")
                            }
                        }
                    }
                }

                CoursePage.CART -> {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        TextButton(onClick = {
                            currentPage = CoursePage.CATALOG
                            message = ""
                        }) {
                            Text("← Voltar ao catálogo")
                        }

                        Text(
                            "Carrinho de compras",
                            style = MaterialTheme.typography.headlineSmall,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(Modifier.height(12.dp))

                        if (cartCourses.isEmpty()) {
                            Text("O carrinho está vazio.")
                        } else {
                            LazyColumn(
                                modifier = Modifier.weight(1f),
                                verticalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                items(cartCourses, key = { it.id }) { course ->
                                    Card(
                                        modifier = Modifier.fillMaxWidth()
                                    ) {
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(12.dp),
                                            horizontalArrangement =
                                                Arrangement.SpaceBetween
                                        ) {
                                            Column(
                                                modifier = Modifier.weight(1f)
                                            ) {
                                                Text(
                                                    course.title,
                                                    fontWeight = FontWeight.Bold
                                                )
                                                Text(formatCoursePrice(course.price))
                                            }

                                            TextButton(onClick = {
                                                cartCourses = cartCourses.filterNot {
                                                    it.id == course.id
                                                }
                                                message = "Curso removido do carrinho."
                                            }) {
                                                Text("Remover")
                                            }
                                        }
                                    }
                                }
                            }

                            Spacer(Modifier.height(12.dp))

                            Text(
                                "Total: ${formatCoursePrice(
                                    cartCourses.sumOf { it.price }
                                )}",
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}

fun formatCoursePrice(price: Double): String =
    NumberFormat.getCurrencyInstance(Locale("pt", "PT")).format(price)
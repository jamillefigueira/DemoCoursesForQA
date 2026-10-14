
package com.example.democoursesforqa

class ShoppingCart {

    private val selectedCourses = mutableListOf<Course>()

    fun addCourse(course: Course): Boolean {
        val alreadyExists = selectedCourses.any {
            it.id == course.id
        }

        if (alreadyExists) {
            return false
        }

        selectedCourses.add(course)
        return true
    }

    fun removeCourse(courseId: Int) {
        selectedCourses.removeAll {
            it.id == courseId
        }
    }

    fun getCourses(): List<Course> {
        return selectedCourses.toList()
    }

    fun getTotal(): Double {
        return selectedCourses.sumOf {
            it.price
        }
    }

    fun isEmpty(): Boolean {
        return selectedCourses.isEmpty()
    }
}


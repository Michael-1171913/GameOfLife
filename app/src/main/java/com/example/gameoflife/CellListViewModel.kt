package com.example.gameoflife

import androidx.lifecycle.ViewModel
import kotlin.random.Random

class Cell {
    public var alive: Boolean = false
}

class CellListViewModel : ViewModel() {
    val cells = mutableListOf<Cell>()

    init {
        for (i in 0 until 144) {
            val cell = Cell()
            cell.alive = Random.nextBoolean()
            cells += cell
        }
    }
}
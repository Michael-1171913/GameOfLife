package com.example.gameoflife

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

private const val TAG = "CellListFragment"

class CellListFragment: Fragment() {

    private lateinit var cellRecyclerView: RecyclerView
    private var adapter: CellAdapater? = null

    private val cellListViewModel: CellListViewModel by lazy {
        ViewModelProviders.of(this).get(CellListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "Total cells: ${cellListViewModel.cells.size}")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cell_list, container, false)

        cellRecyclerView = view.findViewById(R.id.cell_recycler_view) as RecyclerView
        cellRecyclerView.layoutManager = GridLayoutManager(context, 12, RecyclerView.VERTICAL, false)

        updateUI()

        return view
    }

    private fun updateUI() {
        val cells = cellListViewModel.cells
        adapter = CellAdapater(cells)
        cellRecyclerView.adapter = adapter
    }

    companion object {
        fun newInstane(): CellListFragment {
            return CellListFragment()
        }
    }

    private inner class CellViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cellButton: ImageButton = itemView.findViewById(R.id.cell)
    }

    private inner class CellAdapater(var cells: List<Cell>) : RecyclerView.Adapter<CellViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CellViewHolder {
            val view = layoutInflater.inflate(R.layout.list_item_cell, parent, false)
            return CellViewHolder(view)
        }

        override fun onBindViewHolder(holder: CellViewHolder, position: Int) {
            val cell = cells[position]
            holder.apply {
                if(cell.alive) {
                    // TODO
                    //cellButton.setImageResource()
                } else {
                    //cellButton.setBackgroundColor(Color.GRAY)
                }
            }
        }

        override fun getItemCount(): Int {
            return cells.size
        }

    }
}
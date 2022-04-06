package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FooItemBinding
import com.example.myapplication.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */


class FooAdapter(var items: List<String>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class FooViewHolder(val binding: FooItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(header: String) {
            binding.title.text = header
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = FooItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FooViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as FooViewHolder).bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.count()
    }

}

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManger = GridLayoutManager(requireContext(), 4)
        binding.contractList.layoutManager = layoutManger
        binding.contractList.adapter = FooAdapter(listOf("good", "morning", "bye", "bye", "hi"))

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
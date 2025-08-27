package com.flpbrrs.mimigym.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import com.flpbrrs.mimigym.R
import com.flpbrrs.mimigym.databinding.FragmentNewTrainingBinding
import com.flpbrrs.mimigym.ui.extension.hideKeyboard

class NewTrainingFragment : Fragment() {
    private var _binding: FragmentNewTrainingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNewTrainingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupFields()
        initListeners()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setupFields() = with(binding) {
        actTrainingType.setAdapter(
            ArrayAdapter(
                requireContext(),
                R.layout.item_app_dropdown,
                listOf("A", "B", "C", "D", "E", "F")
            )
        )
    }

    private fun initListeners() = with(binding) {
        tietTrainingName.setOnEditorActionListener { v, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                v.clearFocus()
                v.hideKeyboard()
                true
            } else false
        }
    }
}
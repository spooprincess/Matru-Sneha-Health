package com.matrusneh.ui.nutrition

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.matrusneh.R
import com.matrusneh.databinding.FragmentNutritionBinding

class NutritionFragment : Fragment() {

    private var _binding: FragmentNutritionBinding? = null
    private val binding get() = _binding!!

    private val vm: NutritionViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNutritionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val tips = resources.getStringArray(R.array.weekly_growth_tips).toList()

        vm.state.observe(viewLifecycleOwner) { s ->
            binding.textDate.text = s.dateIso
            binding.checkboxRagi.isChecked = s.ragi
            binding.checkboxGreens.isChecked = s.greens
            binding.checkboxPulses.isChecked = s.pulses
            binding.checkboxMilk.isChecked = s.milk
            binding.checkboxFruits.isChecked = s.fruits
            binding.textTip.text = s.weeklyTip
        }

        fun currentState(): NutritionUiState {
            return NutritionUiState(
                dateIso = binding.textDate.text?.toString().orEmpty(),
                ragi = binding.checkboxRagi.isChecked,
                greens = binding.checkboxGreens.isChecked,
                pulses = binding.checkboxPulses.isChecked,
                milk = binding.checkboxMilk.isChecked,
                fruits = binding.checkboxFruits.isChecked,
                weeklyTip = binding.textTip.text?.toString().orEmpty()
            )
        }

        val onChange = View.OnClickListener {
            vm.saveToday(currentState())
        }
        binding.checkboxRagi.setOnClickListener(onChange)
        binding.checkboxGreens.setOnClickListener(onChange)
        binding.checkboxPulses.setOnClickListener(onChange)
        binding.checkboxMilk.setOnClickListener(onChange)
        binding.checkboxFruits.setOnClickListener(onChange)

        vm.loadToday(tips)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


package com.matrusneh.ui.checkup

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.matrusneh.databinding.FragmentCheckupBinding
import java.util.Calendar

class CheckupFragment : Fragment() {

    private var _binding: FragmentCheckupBinding? = null
    private val binding get() = _binding!!

    private val vm: CheckupViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCheckupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnPickDate.setOnClickListener { showDatePicker() }
        binding.btnSaveDate.setOnClickListener {
            val iso = binding.editLastDate.text?.toString()?.trim().orEmpty()
            if (iso.isNotEmpty()) vm.setLastDate(iso)
        }

        vm.state.observe(viewLifecycleOwner) { s ->
            binding.editLastDate.setText(s.lastDateIso)
            binding.textNextDate.text = s.nextDateIso.ifEmpty { "-" }
            binding.textDaysRemaining.text = s.daysRemaining?.toString() ?: "-"
        }

        vm.load()
    }

    private fun showDatePicker() {
        val c = Calendar.getInstance()
        val dialog = DatePickerDialog(
            requireContext(),
            { _, year, month, dayOfMonth ->
                val mm = (month + 1).toString().padStart(2, '0')
                val dd = dayOfMonth.toString().padStart(2, '0')
                binding.editLastDate.setText("$year-$mm-$dd")
            },
            c.get(Calendar.YEAR),
            c.get(Calendar.MONTH),
            c.get(Calendar.DAY_OF_MONTH)
        )
        dialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


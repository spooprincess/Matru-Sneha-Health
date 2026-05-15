package com.matrusneh.ui.health

import android.media.AudioManager
import android.media.ToneGenerator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.matrusneh.R
import com.matrusneh.databinding.FragmentHealthAlertBinding

class HealthAlertFragment : Fragment() {

    private var _binding: FragmentHealthAlertBinding? = null
    private val binding get() = _binding!!

    private var tone: ToneGenerator? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHealthAlertBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tone = ToneGenerator(AudioManager.STREAM_ALARM, 100)

        binding.btnCheck.setOnClickListener { evaluate() }
        binding.switchSound.setOnCheckedChangeListener { _, _ -> /* no-op */ }
    }

    private fun evaluate() {
        val swelling = binding.spinnerSwelling.selectedItem?.toString().orEmpty()
        val headache = binding.checkboxHeadache.isChecked
        val blurred = binding.checkboxBlurred.isChecked
        val bleeding = binding.checkboxBleeding.isChecked

        val danger = swelling.equals(getString(R.string.swelling_high), ignoreCase = true) || blurred || bleeding

        binding.cardDanger.isVisible = danger
        binding.cardSafe.isVisible = !danger

        if (danger && binding.switchSound.isChecked) {
            tone?.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD, 1200)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        tone?.release()
        tone = null
        _binding = null
    }
}


package com.matrusneh.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import com.matrusneh.R
import com.matrusneh.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.cardKick.setOnClickListener {
            findNavController().navigate(R.id.action_dashboard_to_kick)
        }
        binding.cardCheckup.setOnClickListener {
            findNavController().navigate(R.id.action_dashboard_to_checkup)
        }
        binding.cardNutrition.setOnClickListener {
            findNavController().navigate(R.id.action_dashboard_to_nutrition)
        }
        binding.cardHealth.setOnClickListener {
            findNavController().navigate(R.id.action_dashboard_to_health)
        }

        val prefs = PreferenceManager.getDefaultSharedPreferences(requireContext())
        val current = prefs.getString("pref_lang", "en") ?: "en"
        binding.toggleLang.isChecked = current == "kn"

        binding.toggleLang.setOnCheckedChangeListener { _, isChecked ->
            val lang = if (isChecked) "kn" else "en"
            prefs.edit().putString("pref_lang", lang).apply()
            AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(lang))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


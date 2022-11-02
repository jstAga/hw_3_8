package com.geektech.hw_3_8

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.geektech.hw_3_8.adapter.HeroAdapter
import com.geektech.hw_3_8.databinding.FragmentMainBinding
import com.geektech.hw_3_8.model.HeroModel


class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private var heroList = arrayListOf<HeroModel>()
    private lateinit var adapter:HeroAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()

        adapter = HeroAdapter(heroList,this::onItemClick)
        binding.rvHero.adapter =adapter
    }

    private fun onItemClick(position:Int){
        findNavController().navigate(MainFragmentDirections.actionMainFragmentToSecondFragment(heroList, position))
    }

    private fun loadData() {
        heroList.add(HeroModel("Naruto Uzumaki", "alive", "https://i1.sndcdn.com/artworks-000139163741-dk8qn7-t500x500.jpg"))
        heroList.add(HeroModel("Jiraiya","dead","https://pbs.twimg.com/media/EDua4dpXsAEGhfX.jpg"))
        heroList.add(HeroModel("Hidan","???","https://i.pinimg.com/originals/8b/f7/19/8bf71907ab6eaff00a8fd89c2d1546d9.jpg"))
        heroList.add(HeroModel("Sasuke Uchiha","alive","https://aniyuki.com/wp-content/uploads/2022/04/aniyuki-sasuke-uchiha-avatar-1.jpg"))
        heroList.add(HeroModel("Might Guy","alive","https://i.pinimg.com/originals/1b/f5/27/1bf527b825107610a52302f81907f273.jpg"))
        heroList.add(HeroModel("Kakashi Hatake","alive","https://i.pinimg.com/originals/17/b2/86/17b2860d84a83c785f0944296f33310a.jpg"))
        heroList.add(HeroModel("Gaara","alive","https://avatarfiles.alphacoders.com/322/322318.png"))
        heroList.add(HeroModel("Minato Namikadze","dead","https://pm1.narvii.com/6286/5034f8e1dee25474cb1f6916e3bcde1cb63f5aae_hq.jpg"))
        heroList.add(HeroModel("Nara Shikamaru","alive","https://i.pinimg.com/736x/6a/60/c0/6a60c02cdfa4a5aa8deb5c2c25336fbd.jpg"))
        heroList.add(HeroModel("Deidara","dead","https://i.pinimg.com/736x/de/d0/55/ded05583cc353bebf69f1c258939c2b3.jpg"))
    }

}
package com.anavigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

sealed class LifestyleServicesTypes(@StringRes open val titleRes: Int, @StringRes open val taglineRes: Int,
                                    open val bannerUrl: String, @StringRes open val link: Int) {

    val type: String
        get() =
            when (this) {
                is HousingServices -> "Housing"
                is PetServices -> "Pets"
                is FoodServices -> "Food"
                is ClothesServices -> "Clothes"
            }

    data class HousingServices(override val titleRes: Int, override val  taglineRes: Int,
                               override val  bannerUrl: String, override val  link: Int): LifestyleServicesTypes(titleRes, taglineRes, bannerUrl, link)
    data class PetServices(override val  titleRes: Int, override val taglineRes: Int,
                           override val  bannerUrl: String, override val  link: Int) : LifestyleServicesTypes(titleRes, taglineRes, bannerUrl, link)
    data class FoodServices(override val titleRes: Int, override val  taglineRes: Int,
                               override val  bannerUrl: String, override val  link: Int): LifestyleServicesTypes(titleRes, taglineRes, bannerUrl, link)
    data class ClothesServices(override val titleRes: Int, override val  taglineRes: Int,
                               override val  bannerUrl: String, override val  link: Int): LifestyleServicesTypes(titleRes, taglineRes, bannerUrl, link)

    companion object {
        fun getAllServices(): List<LifestyleServicesTypes> {
            return listOf(

                HousingServices(R.string.helix_title, R.string.helix_tagline, "https://images.unsplash.com/photo-1513977055326-8ae6272d90a7?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80", R.string.helix_link),
                HousingServices(R.string.shipt_title, R.string.shipt_tagline, "https://images.unsplash.com/photo-1513977055326-8ae6272d90a7?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80", R.string.shipt_link),
                HousingServices(R.string.setter_title, R.string.setter_tagline, "https://images.unsplash.com/photo-1513977055326-8ae6272d90a7?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80", R.string.setter_link),
                HousingServices(R.string.unboxes_title, R.string.unboxes_tagline, "https://images.unsplash.com/photo-1513977055326-8ae6272d90a7?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80", R.string.unboxes_link),
                HousingServices(R.string.lemonade_title, R.string.lemonade_tagline, "https://images.unsplash.com/photo-1513977055326-8ae6272d90a7?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80", R.string.lemonade_link),

                FoodServices(R.string.home_chef_title, R.string.home_chef_tagline, "https://images.unsplash.com/photo-1513977055326-8ae6272d90a7?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80", R.string.home_chef_link),

                ClothesServices(R.string.rinse_title, R.string.rinse_tagline, "https://images.unsplash.com/photo-1513977055326-8ae6272d90a7?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80", R.string.rinse_link),

                PetServices(R.string.wag_title, R.string.wag_tagline, "https://images.unsplash.com/photo-1513977055326-8ae6272d90a7?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=750&q=80", R.string.wag_link)
            )
        }
    }
}
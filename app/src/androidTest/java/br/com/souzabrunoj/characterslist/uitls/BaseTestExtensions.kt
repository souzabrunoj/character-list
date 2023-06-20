package br.com.souzabrunoj.characterslist.uitls

import android.os.Bundle
import androidx.annotation.StyleRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.Navigation.setViewNavController
import br.com.souzabrunoj.characterslist.CharacterDetailsFragmentTest
import br.com.souzabrunoj.characterslist.R
import br.com.souzabrunoj.characterslist.presentation.ui.details.CharacterDetailsFragment
import kotlinx.coroutines.ExperimentalCoroutinesApi

/**
 * Launches a Fragment in the Activity's root view container `android.R.id.content`, with
 * given arguments hosted by an empty [FragmentActivity]
 *
 * This method cannot be called from the main thread.
 *
 * @param fragmentArgs a bundle to passed into fragment
 * @param themeResId a style resource id to be set to the host activity's theme
 * @param runOnUiThread a callback function to be invoked immediately
 * after Fragment's [onCreateView()] is called
 */
inline fun <reified F : Fragment> BaseTest.launchFragmentInContainer(
    fragmentArgs: Bundle? = null,
    @StyleRes themeResId: Int = R.style.Base_Theme_CharactersList,
    noinline runOnUiThread: ((F) -> Unit)? = null
) {
    androidx.fragment.app.testing.launchFragmentInContainer(fragmentArgs, themeResId) {
        F::class.java.newInstance().also { fragment ->
            fragment.viewLifecycleOwnerLiveData.observeForever { viewLifecycleOwner ->
                viewLifecycleOwner?.let {
                    setViewNavController(fragment.requireView(), navController)
                    runOnUiThread?.invoke(fragment)
                }
            }
        }
    }
}

@ExperimentalCoroutinesApi
internal fun CharacterDetailsFragmentTest.onLaunch(
    bundle: Bundle? = null,
    action: CharacterDetailsFragmentTest.() -> Unit = {},
) {
    launchFragmentInContainer<CharacterDetailsFragment>(fragmentArgs = bundle)
    navController.setGraph(R.navigation.app_navigation_graph)
    navController.setCurrentDestination(R.id.character_details_fragment)

    action.invoke(this)
}
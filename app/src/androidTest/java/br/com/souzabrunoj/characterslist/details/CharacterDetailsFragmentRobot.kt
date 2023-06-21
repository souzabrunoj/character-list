package br.com.souzabrunoj.characterslist.details

import android.os.Bundle
import androidx.test.platform.app.InstrumentationRegistry
import br.com.souzabrunoj.characterslist.CharacterDetailsFragmentTest
import br.com.souzabrunoj.characterslist.R
import br.com.souzabrunoj.characterslist.presentation.ui.details.CharacterDetailsFragment
import br.com.souzabrunoj.characterslist.uitls.BaseRobot
import br.com.souzabrunoj.characterslist.uitls.launchFragmentInContainer
import kotlinx.coroutines.ExperimentalCoroutinesApi

private val CHARACTER_NAME_VIEW_ID = R.id.tv_character_name
private val CHARACTER_STATUS_VIEW_ID = R.id.tv_status
private val CHARACTER_SPECIES_VIEW_ID = R.id.tv_species
private val CHARACTER_GENDER_VIEW_ID = R.id.tv_gender
private val CHARACTER_LOCATION_VIEW_ID = R.id.tv_location
private val CHARACTER_ERROR_VIEW_ID = R.id.tv_error_massage
private val CHARACTER_GROUP_CONTAINER_VIEW_ID = R.id.gp_character_data

class CharacterDetailsFragmentRobot(action: (CharacterDetailsFragmentRobot) -> Unit) : BaseRobot() {

    private val context = InstrumentationRegistry.getInstrumentation().targetContext

    init {
        action.invoke(this)
    }

    fun checkCharacterData() {
        val status = context.getString(R.string.character_status_string_format, "Alive")
        val species = context.getString(R.string.character_species_string_format, "Human")
        val gender = context.getString(R.string.character_gender_string_format, "Male")
        val location = context.getString(R.string.location_string_format, "Citadel of Ricks")

        assertText(CHARACTER_NAME_VIEW_ID, "Morty Smith")
        assertText(CHARACTER_STATUS_VIEW_ID, status)
        assertText(CHARACTER_SPECIES_VIEW_ID, species)
        assertText(CHARACTER_GENDER_VIEW_ID, gender)
        assertText(CHARACTER_LOCATION_VIEW_ID, location)
        checkIfViewIsNotDisplayed(CHARACTER_ERROR_VIEW_ID)
    }

    fun checkErrorState() {
        assertText(CHARACTER_ERROR_VIEW_ID, "Error querying our server, please try again later!")
        checkIfViewIsNotDisplayed(CHARACTER_GROUP_CONTAINER_VIEW_ID)
    }
}

@ExperimentalCoroutinesApi
internal fun CharacterDetailsFragmentTest.onLaunch(
    bundle: Bundle? = null,
    action: CharacterDetailsFragmentRobot.() -> Unit = {},
): CharacterDetailsFragmentRobot {
    launchFragmentInContainer<CharacterDetailsFragment>(fragmentArgs = bundle) {
        navController.setGraph(R.navigation.app_navigation_graph)
        navController.graph.setStartDestination(R.id.character_details_fragment)
    }
    return CharacterDetailsFragmentRobot(action)
}
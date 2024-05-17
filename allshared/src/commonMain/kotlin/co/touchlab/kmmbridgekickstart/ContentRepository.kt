import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import co.touchlab.kmmbridgekickstart.EpisodeSortEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapNotNull

class ContentRepository(
    private val dataStore: DataStore<Preferences>
) {
    
    fun observe(contentId: String): Flow<EpisodeSortEntity> {
        return dataStore.data.map {
            val key = getContentKey(contentId)
            
            it[key]
        }
            .filterNotNull()
            .map { name ->
                EpisodeSortEntity(
                    contentId = contentId,
                    type = EpisodeSortType.valueOf(name) 
                )
            }
    }
   
    suspend fun save(contentId: String, type: EpisodeSortType) {
        dataStore.edit {
            val key = getContentKey(contentId)
            it[key] = type.name
        }
    }
    
    private fun getContentKey(contentId: String) = stringPreferencesKey(contentId)
}
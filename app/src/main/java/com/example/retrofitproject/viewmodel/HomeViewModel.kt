import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.retrofitproject.Repository.HomeActivityRepository
import com.example.retrofitproject.model.Todos


class HomeViewModel: ViewModel() {

    var todoLiveData: MutableLiveData<List<Todos>>? = null
    var homeActivityRepository:HomeActivityRepository? = null

    fun setHomeRepository(homeActivityRepository: HomeActivityRepository){
        this.homeActivityRepository = homeActivityRepository
    }

    fun getServicesAPICall(): LiveData<List<Todos>>{
        todoLiveData = homeActivityRepository?.getServicesApiCall()
        return todoLiveData as MutableLiveData<List<Todos>>
    }

    fun getFailure(): LiveData<String>?{
        return homeActivityRepository?.failureData
    }
}
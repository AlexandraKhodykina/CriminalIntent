package com.bignerdranch.android.criminalintent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import java.util.UUID

class CrimeDetailViewModel () : ViewModel() {
    private val crimeRepository = CrimeRepository.get()
    private val crimeIdLiveData = MutableLiveData<UUID>()

    var crimeLiveData = crimeIdLiveData.switchMap { crimeId -> crimeRepository.getCrime(crimeId) }
//var crimeLiveData: LiveData<Crime?> =
//Transformations.switchMap(crimeIdLiveData) { crimeId ->
//crimeRepository.getCrime(crimeId)
//}
    fun loadCrime(crimeId: UUID) {
        crimeIdLiveData.value = crimeId

    }
    fun saveCrime(crime: Crime) {
        crimeRepository.updateCrime(crime)
    }

}
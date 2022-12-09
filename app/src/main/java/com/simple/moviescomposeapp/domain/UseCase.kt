package com.simple.moviescomposeapp.domain

interface UseCase<P, R> {
    suspend fun execute(param: P): R
}
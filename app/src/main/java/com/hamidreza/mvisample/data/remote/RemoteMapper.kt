package com.hamidreza.mvisample.data.remote

import com.hamidreza.mvisample.data.model.User
import com.hamidreza.mvisample.data.remote.UserRemoteModel.Address
import com.hamidreza.mvisample.data.remote.UserRemoteModel.Company
import com.hamidreza.mvisample.data.remote.UserRemoteModel.UserRemoteEntity
import com.hamidreza.mvisample.utils.EntityMapper

class RemoteMapper : EntityMapper<UserRemoteEntity, User> {
    override fun mapFromEntity(entity: UserRemoteEntity): User {
        return User(
            id = entity.id,
            email = entity.email,
            name = entity.name,
            phone = entity.phone,
            city = entity.address.city,
            companyName = entity.company.name
        )
    }

    override fun mapToEntity(domainModel: User): UserRemoteEntity {
        return UserRemoteEntity(
            address = Address(domainModel.city),
            company = Company(domainModel.companyName),
            email = domainModel.email,
            id = domainModel.id,
            name = domainModel.name,
            phone = domainModel.phone
        )
    }

    fun mapFromEntityList(entities:List<UserRemoteEntity>) : List<User> {
        return entities.map {
            mapFromEntity(it)
        }
    }
}
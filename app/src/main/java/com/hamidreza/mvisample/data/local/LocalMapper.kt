package com.hamidreza.mvisample.data.local

import com.hamidreza.mvisample.data.model.User
import com.hamidreza.mvisample.utils.EntityMapper

class LocalMapper : EntityMapper<UserLocalEntity,User> {
    override fun mapFromEntity(entity: UserLocalEntity): User {
        return User(
            id = entity.id,
            email = entity.email,
            name = entity.name,
            phone = entity.phone,
            city = entity.city,
            companyName = entity.companyName
        )
    }

    override fun mapToEntity(domainModel: User): UserLocalEntity {
        return UserLocalEntity(
            id = domainModel.id,
            email = domainModel.email,
            name = domainModel.name,
            phone = domainModel.phone,
            city = domainModel.city,
            companyName = domainModel.companyName
        )
    }

    fun mapFromEntityList(entities: List<UserLocalEntity>) : List<User> {
        return entities.map {
            mapFromEntity(it)
        }
    }
}
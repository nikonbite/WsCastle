package me.nikonbite.wscastle.messenger.bundle


import com.fasterxml.jackson.databind.ObjectMapper

// TODO: realize write and read methods!
interface Bundle {
    val mapper: ObjectMapper
        get() = ObjectMapper()

    fun read(): String {
        return mapper.writeValueAsString(this)
    }

    fun write(bundle: Bundle, json: String) {
        val node = mapper.readTree(json)
        val fields = bundle.javaClass.getDeclaredFields()
        for (field in fields) {
                field.setAccessible(true)
                val fieldName = field.name
                if (node.has(fieldName)) {
                    val value = mapper.treeToValue(node[fieldName], field.type)
                    field[bundle] = value
                }
        }
    }
}
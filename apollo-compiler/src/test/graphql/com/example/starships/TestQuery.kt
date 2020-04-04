// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.starships

import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.OperationName
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.ScalarTypeAdapters
import com.apollographql.apollo.api.ScalarTypeAdapters.Companion.DEFAULT
import com.apollographql.apollo.api.internal.InputFieldMarshaller
import com.apollographql.apollo.api.internal.QueryDocumentMinifier
import com.apollographql.apollo.api.internal.ResponseFieldMapper
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.SimpleOperationResponseParser
import com.apollographql.apollo.api.internal.Throws
import com.example.starships.type.CustomType
import kotlin.Any
import kotlin.Array
import kotlin.Double
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import kotlin.collections.Map
import kotlin.jvm.Transient
import okio.BufferedSource
import okio.IOException

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter")
data class TestQuery(
  val id: String
) : Query<TestQuery.Data, TestQuery.Data, Operation.Variables> {
  @Transient
  private val variables: Operation.Variables = object : Operation.Variables() {
    override fun valueMap(): Map<String, Any?> = mutableMapOf<String, Any?>().apply {
      this["id"] = this@TestQuery.id
    }

    override fun marshaller(): InputFieldMarshaller = InputFieldMarshaller.invoke { writer ->
      writer.writeCustom("id", CustomType.ID, this@TestQuery.id)
    }
  }

  override fun operationId(): String = OPERATION_ID
  override fun queryDocument(): String = QUERY_DOCUMENT
  override fun wrapData(data: Data?): Data? = data
  override fun variables(): Operation.Variables = variables
  override fun name(): OperationName = OPERATION_NAME
  override fun responseFieldMapper(): ResponseFieldMapper<Data> = ResponseFieldMapper.invoke {
    Data(it)
  }

  @Throws(IOException::class)
  override fun parse(source: BufferedSource, scalarTypeAdapters: ScalarTypeAdapters): Response<Data>
      = SimpleOperationResponseParser.parse(source, this, scalarTypeAdapters)

  @Throws(IOException::class)
  override fun parse(source: BufferedSource): Response<Data> = parse(source, DEFAULT)

  data class Starship(
    val __typename: String = "Starship",
    /**
     * The ID of the starship
     */
    val id: String,
    /**
     * The name of the starship
     */
    val name: String,
    val coordinates: List<List<Double>>?
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@Starship.__typename)
      writer.writeCustom(RESPONSE_FIELDS[1] as ResponseField.CustomTypeField, this@Starship.id)
      writer.writeString(RESPONSE_FIELDS[2], this@Starship.name)
      writer.writeList(RESPONSE_FIELDS[3], this@Starship.coordinates) { value, listItemWriter ->
        value?.forEach { value ->
          listItemWriter.writeList(value) { value, listItemWriter ->
            value?.forEach { value ->
              listItemWriter.writeDouble(value)}
          }
        }
      }
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forCustomType("id", "id", null, false, CustomType.ID, null),
          ResponseField.forString("name", "name", null, false, null),
          ResponseField.forList("coordinates", "coordinates", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): Starship = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val id = readCustomType<String>(RESPONSE_FIELDS[1] as ResponseField.CustomTypeField)!!
        val name = readString(RESPONSE_FIELDS[2])!!
        val coordinates = readList<List<Double>>(RESPONSE_FIELDS[3]) { reader ->
          reader.readList<Double> { reader ->
            reader.readDouble()
          }.map { it!! }
        }?.map { it!! }
        Starship(
          __typename = __typename,
          id = id,
          name = name,
          coordinates = coordinates
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Starship> = ResponseFieldMapper { invoke(it) }
    }
  }

  data class Data(
    val starship: Starship?
  ) : Operation.Data {
    override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeObject(RESPONSE_FIELDS[0], this@Data.starship?.marshaller())
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forObject("starship", "starship", mapOf<String, Any>(
            "id" to mapOf<String, Any>(
              "kind" to "Variable",
              "variableName" to "id")), true, null)
          )

      operator fun invoke(reader: ResponseReader): Data = reader.run {
        val starship = readObject<Starship>(RESPONSE_FIELDS[0]) { reader ->
          Starship(reader)
        }
        Data(
          starship = starship
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Data> = ResponseFieldMapper { invoke(it) }
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "a4c440f9a7ea17b55ba60d3ac9603f8be88a1db31c679f55982eb9f57b5b6181"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query TestQuery(${'$'}id: ID!) {
          |  starship(id: ${'$'}id) {
          |    __typename
          |    id
          |    name
          |    coordinates
          |  }
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: OperationName = object : OperationName {
      override fun name(): String = "TestQuery"
    }
  }
}

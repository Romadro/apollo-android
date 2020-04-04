// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.fragment_in_fragment.fragment

import com.apollographql.apollo.api.GraphqlFragment
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseFieldMapper
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.apollographql.apollo.api.internal.ResponseReader
import kotlin.Array
import kotlin.String
import kotlin.Suppress

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter")
data class PlanetFragment(
  val __typename: String = "Planet",
  /**
   * The name of this planet.
   */
  val name: String?
) : GraphqlFragment {
  override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
    writer.writeString(RESPONSE_FIELDS[0], this@PlanetFragment.__typename)
    writer.writeString(RESPONSE_FIELDS[1], this@PlanetFragment.name)
  }

  companion object {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.forString("__typename", "__typename", null, false, null),
        ResponseField.forString("name", "name", null, true, null)
        )

    val FRAGMENT_DEFINITION: String = """
        |fragment planetFragment on Planet {
        |  __typename
        |  name
        |}
        """.trimMargin()

    operator fun invoke(reader: ResponseReader): PlanetFragment = reader.run {
      val __typename = readString(RESPONSE_FIELDS[0])!!
      val name = readString(RESPONSE_FIELDS[1])
      PlanetFragment(
        __typename = __typename,
        name = name
      )
    }

    @Suppress("FunctionName")
    fun Mapper(): ResponseFieldMapper<PlanetFragment> = ResponseFieldMapper { invoke(it) }
  }
}

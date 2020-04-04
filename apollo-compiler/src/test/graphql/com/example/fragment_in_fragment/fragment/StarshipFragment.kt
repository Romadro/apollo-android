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
import com.example.fragment_in_fragment.type.CustomType
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter")
data class StarshipFragment(
  val __typename: String = "Starship",
  /**
   * The ID of an object
   */
  val id: String,
  /**
   * The name of this starship. The common name, such as "Death Star".
   */
  val name: String?,
  val pilotConnection: PilotConnection?
) : GraphqlFragment {
  override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
    writer.writeString(RESPONSE_FIELDS[0], this@StarshipFragment.__typename)
    writer.writeCustom(RESPONSE_FIELDS[1] as ResponseField.CustomTypeField,
        this@StarshipFragment.id)
    writer.writeString(RESPONSE_FIELDS[2], this@StarshipFragment.name)
    writer.writeObject(RESPONSE_FIELDS[3], this@StarshipFragment.pilotConnection?.marshaller())
  }

  companion object {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField.forString("__typename", "__typename", null, false, null),
        ResponseField.forCustomType("id", "id", null, false, CustomType.ID, null),
        ResponseField.forString("name", "name", null, true, null),
        ResponseField.forObject("pilotConnection", "pilotConnection", null, true, null)
        )

    val FRAGMENT_DEFINITION: String = """
        |fragment starshipFragment on Starship {
        |  __typename
        |  id
        |  name
        |  pilotConnection {
        |    __typename
        |    edges {
        |      __typename
        |      node {
        |        __typename
        |        ...pilotFragment
        |      }
        |    }
        |  }
        |}
        """.trimMargin()

    operator fun invoke(reader: ResponseReader): StarshipFragment = reader.run {
      val __typename = readString(RESPONSE_FIELDS[0])!!
      val id = readCustomType<String>(RESPONSE_FIELDS[1] as ResponseField.CustomTypeField)!!
      val name = readString(RESPONSE_FIELDS[2])
      val pilotConnection = readObject<PilotConnection>(RESPONSE_FIELDS[3]) { reader ->
        PilotConnection(reader)
      }
      StarshipFragment(
        __typename = __typename,
        id = id,
        name = name,
        pilotConnection = pilotConnection
      )
    }

    @Suppress("FunctionName")
    fun Mapper(): ResponseFieldMapper<StarshipFragment> = ResponseFieldMapper { invoke(it) }
  }

  data class Node(
    val __typename: String = "Person",
    val fragments: Fragments
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@Node.__typename)
      this@Node.fragments.marshaller().marshal(writer)
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("__typename", "__typename", null, false, null)
          )

      operator fun invoke(reader: ResponseReader): Node = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val fragments = Fragments(reader)
        Node(
          __typename = __typename,
          fragments = fragments
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Node> = ResponseFieldMapper { invoke(it) }
    }

    data class Fragments(
      val pilotFragment: PilotFragment
    ) {
      fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
        writer.writeFragment(this@Fragments.pilotFragment.marshaller())
      }

      companion object {
        private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
            ResponseField.forFragment("__typename", "__typename", null)
            )

        operator fun invoke(reader: ResponseReader): Fragments = reader.run {
          val pilotFragment = readFragment<PilotFragment>(RESPONSE_FIELDS[0]) { reader ->
            PilotFragment(reader)
          }!!
          Fragments(
            pilotFragment = pilotFragment
          )
        }

        @Suppress("FunctionName")
        fun Mapper(): ResponseFieldMapper<Fragments> = ResponseFieldMapper { invoke(it) }
      }
    }
  }

  data class Edge(
    val __typename: String = "StarshipPilotsEdge",
    /**
     * The item at the end of the edge
     */
    val node: Node?
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@Edge.__typename)
      writer.writeObject(RESPONSE_FIELDS[1], this@Edge.node?.marshaller())
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forObject("node", "node", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): Edge = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val node = readObject<Node>(RESPONSE_FIELDS[1]) { reader ->
          Node(reader)
        }
        Edge(
          __typename = __typename,
          node = node
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Edge> = ResponseFieldMapper { invoke(it) }
    }
  }

  data class PilotConnection(
    val __typename: String = "StarshipPilotsConnection",
    /**
     * A list of edges.
     */
    val edges: List<Edge?>?
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@PilotConnection.__typename)
      writer.writeList(RESPONSE_FIELDS[1], this@PilotConnection.edges) { value, listItemWriter ->
        value?.forEach { value ->
          listItemWriter.writeObject(value?.marshaller())}
      }
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forList("edges", "edges", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): PilotConnection = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val edges = readList<Edge>(RESPONSE_FIELDS[1]) { reader ->
          reader.readObject<Edge> { reader ->
            Edge(reader)
          }
        }
        PilotConnection(
          __typename = __typename,
          edges = edges
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<PilotConnection> = ResponseFieldMapper { invoke(it) }
    }
  }
}

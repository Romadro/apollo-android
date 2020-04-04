// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.hero_details

import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.OperationName
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.ScalarTypeAdapters
import com.apollographql.apollo.api.ScalarTypeAdapters.Companion.DEFAULT
import com.apollographql.apollo.api.internal.QueryDocumentMinifier
import com.apollographql.apollo.api.internal.ResponseFieldMapper
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.SimpleOperationResponseParser
import com.apollographql.apollo.api.internal.Throws
import com.example.hero_details.type.Hero_type
import kotlin.Array
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import okio.BufferedSource
import okio.IOException

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter")
class HeroDetails : Query<HeroDetails.Data, HeroDetails.Data, Operation.Variables> {
  override fun operationId(): String = OPERATION_ID
  override fun queryDocument(): String = QUERY_DOCUMENT
  override fun wrapData(data: Data?): Data? = data
  override fun variables(): Operation.Variables = Operation.EMPTY_VARIABLES
  override fun name(): OperationName = OPERATION_NAME
  override fun responseFieldMapper(): ResponseFieldMapper<Data> = ResponseFieldMapper.invoke {
    Data(it)
  }

  @Throws(IOException::class)
  override fun parse(source: BufferedSource, scalarTypeAdapters: ScalarTypeAdapters): Response<Data>
      = SimpleOperationResponseParser.parse(source, this, scalarTypeAdapters)

  @Throws(IOException::class)
  override fun parse(source: BufferedSource): Response<Data> = parse(source, DEFAULT)

  data class Node(
    val __typename: String = "Character",
    /**
     * The name of the character
     */
    val name: String
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@Node.__typename)
      writer.writeString(RESPONSE_FIELDS[1], this@Node.name)
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("name", "name", null, false, null)
          )

      operator fun invoke(reader: ResponseReader): Node = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val name = readString(RESPONSE_FIELDS[1])!!
        Node(
          __typename = __typename,
          name = name
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Node> = ResponseFieldMapper { invoke(it) }
    }
  }

  data class Edge(
    val __typename: String = "FriendsEdge",
    /**
     * The character represented by this friendship edge
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

  data class FriendsConnection(
    val __typename: String = "FriendsConnection",
    /**
     * The total number of friends
     */
    val totalCount: Int?,
    /**
     * The edges for each of the character's friends.
     */
    val edges: List<Edge?>?
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@FriendsConnection.__typename)
      writer.writeInt(RESPONSE_FIELDS[1], this@FriendsConnection.totalCount)
      writer.writeList(RESPONSE_FIELDS[2], this@FriendsConnection.edges) { value, listItemWriter ->
        value?.forEach { value ->
          listItemWriter.writeObject(value?.marshaller())}
      }
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forInt("totalCount", "totalCount", null, true, null),
          ResponseField.forList("edges", "edges", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): FriendsConnection = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val totalCount = readInt(RESPONSE_FIELDS[1])
        val edges = readList<Edge>(RESPONSE_FIELDS[2]) { reader ->
          reader.readObject<Edge> { reader ->
            Edge(reader)
          }
        }
        FriendsConnection(
          __typename = __typename,
          totalCount = totalCount,
          edges = edges
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<FriendsConnection> = ResponseFieldMapper { invoke(it) }
    }
  }

  data class Hero(
    val __typename: String = "Character",
    /**
     * Hero type
     */
    val type: Hero_type,
    /**
     * The name of the character
     */
    val name: String,
    /**
     * The friends of the character exposed as a connection with edges
     */
    val friendsConnection: FriendsConnection
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@Hero.__typename)
      writer.writeString(RESPONSE_FIELDS[1], this@Hero.type.rawValue)
      writer.writeString(RESPONSE_FIELDS[2], this@Hero.name)
      writer.writeObject(RESPONSE_FIELDS[3], this@Hero.friendsConnection.marshaller())
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forEnum("type", "type", null, false, null),
          ResponseField.forString("name", "name", null, false, null),
          ResponseField.forObject("friendsConnection", "friendsConnection", null, false, null)
          )

      operator fun invoke(reader: ResponseReader): Hero = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val type = Hero_type.safeValueOf(readString(RESPONSE_FIELDS[1])!!)
        val name = readString(RESPONSE_FIELDS[2])!!
        val friendsConnection = readObject<FriendsConnection>(RESPONSE_FIELDS[3]) { reader ->
          FriendsConnection(reader)
        }!!
        Hero(
          __typename = __typename,
          type = type,
          name = name,
          friendsConnection = friendsConnection
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Hero> = ResponseFieldMapper { invoke(it) }
    }
  }

  data class Data(
    val hero: Hero?
  ) : Operation.Data {
    override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeObject(RESPONSE_FIELDS[0], this@Data.hero?.marshaller())
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forObject("hero", "hero", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): Data = reader.run {
        val hero = readObject<Hero>(RESPONSE_FIELDS[0]) { reader ->
          Hero(reader)
        }
        Data(
          hero = hero
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Data> = ResponseFieldMapper { invoke(it) }
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "e9e881883e577da3a4dc0ea9eedbdbc8a05f65fe08bd6f1ae6c1e993b75dfbe4"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query HeroDetails {
          |  hero {
          |    __typename
          |    type
          |    name
          |    friendsConnection {
          |      __typename
          |      totalCount
          |      edges {
          |        __typename
          |        node {
          |          __typename
          |          name
          |        }
          |      }
          |    }
          |  }
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: OperationName = object : OperationName {
      override fun name(): String = "HeroDetails"
    }
  }
}

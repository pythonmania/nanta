package controllers

import play.api._
import play.api.mvc._
import play.api.libs.json.Json._
import play.api.db._
import play.api.Play.current
import scala.collection.JavaConversions._
import models._
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import play.api.libs.json._
import play.api.libs.json.JsValue

object Application extends Controller {
  val jdbcTemplate = new NamedParameterJdbcTemplate(DB.getDataSource("local"))

  def query(cmd: String) = Action { request =>
    val singleMap = for ((key, value) <- request.queryString) yield {
      (key -> value.head)
    }
    val result = jdbcTemplate.queryForList(Query(cmd), mapAsJavaMap(singleMap))

    val jsonResult = toJsonResult(result)

    Ok(toJson(jsonResult toList))
  }

  def toJsonResult(results: java.util.List[java.util.Map[java.lang.String, java.lang.Object]]) = {
    for (result <- results) yield {
      (for ((key, value) <- result) yield {
        (key -> ("" + value))
      }) toMap
    }
  }
}

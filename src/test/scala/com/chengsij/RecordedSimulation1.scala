package com.chengsij

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class RecordedSimulation1 extends Simulation {

	val httpProtocol = http
		.baseUrl("http://computer-database.gatling.io")
		.inferHtmlResources(BlackList(""".*\.css""", """.*\.js""", """.*\.ico"""), WhiteList())
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-US,en;q=0.9")
		.upgradeInsecureRequestsHeader("1")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/77.0.3865.90 Safari/537.36")

	val headers_0 = Map("Proxy-Connection" -> "keep-alive")

	val headers_3 = Map(
		"Origin" -> "http://computer-database.gatling.io",
		"Proxy-Connection" -> "keep-alive")



	val scn = scenario("RecordedSimulation1")
		.exec(http("request_0")
			.get("/")
			.headers(headers_0))
		.pause(7)
		.exec(http("request_1")
			.get("/computers?f=DELL")
			.headers(headers_0))
		.pause(2)
		.exec(http("request_2")
			.get("/computers/332")
			.headers(headers_0))
		.pause(13)
		.exec(http("request_3")
			.post("/computers/332")
			.headers(headers_3)
			.formParam("name", "Dell Latitude")
			.formParam("introduced", "")
			.formParam("discontinued", "")
			.formParam("company", "2"))
		.pause(12)
		.exec(http("request_4")
			.get("/computers/388")
			.headers(headers_0))
		.pause(2)
		.exec(http("request_5")
			.get("/computers")
			.headers(headers_0))
		.pause(3)
		.exec(http("request_6")
			.get("/computers?f=mac")
			.headers(headers_0))
		.pause(7)
		.exec(http("request_7")
			.get("/computers?f=macbook")
			.headers(headers_0))
		.pause(3)
		.exec(http("request_8")
			.get("/computers/1")
			.headers(headers_0))
		.pause(2)
		.exec(http("request_9")
			.post("/computers/1")
			.headers(headers_3)
			.formParam("name", "MacBook Pro 15.4 inch")
			.formParam("introduced", "")
			.formParam("discontinued", "")
			.formParam("company", "1"))
		.pause(5)
		.exec(http("request_10")
			.get("/computers?f=think")
			.headers(headers_0))
		.pause(4)
		.exec(http("request_11")
			.get("/computers?p=1&f=think")
			.headers(headers_0))
		.pause(1)
		.exec(http("request_12")
			.get("/computers/492")
			.headers(headers_0))
		.pause(2)
		.exec(http("request_13")
			.post("/computers/492")
			.headers(headers_3)
			.formParam("name", "lenovo thinkpad x200 tablet")
			.formParam("introduced", "")
			.formParam("discontinued", "")
			.formParam("company", "36"))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}
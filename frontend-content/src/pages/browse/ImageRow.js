import React from "react";
import { Container, Row, Col, Button, Card } from "reactstrap";
import ImageCard from "./ImageCard";
import { Link } from "react-router-dom";

const ImageRow = (props) => {
  return (
    <div>
      <Container className="themed-container">
        {/* <Row className="pr-4 pl-4">
            <div className="d-flex justify-content-between w-100">
              <h4>Action</h4>
              <Link to="/movie/action">View All</Link>
            </div>
          </Row> */}
        <Row xs="1" sm="2" lg="3" xl="4" className="mb-4">
          {props.movies
            ? props.movies.map((movie) => {
                return (
                  <Col>
                    <ImageCard movie={movie} />
                  </Col>
                );
              })
            : ""}

          {props.shows
            ? props.shows.map((show) => {
                return (
                  <Col>
                    <ImageCard show={show} />
                  </Col>
                );
              })
            : ""}
        </Row>
      </Container>
    </div>
  );
};

export default ImageRow;

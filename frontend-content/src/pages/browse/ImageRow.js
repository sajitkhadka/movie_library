import React from "react";
import { Container, Row, Col } from "reactstrap";
import ImageCard from "./ImageCard";

const ImageRow = (props) => {
  return (
    <div>
      <Container className="themed-container">
        <Row xs="1" sm="2" lg="3" xl="4" className="mb-4">
          {props.movies
            ? props.movies.map((movie, i) => {
                return (
                  <Col>
                    <ImageCard movie={movie} key={i} />
                  </Col>
                );
              })
            : ""}

          {props.shows
            ? props.shows.map((show, i) => {
                return (
                  <Col key={i}>
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

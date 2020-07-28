import React from "react";
import { Container, Row, Col, Button, Card } from "reactstrap";
import ImageCard from "./ImageCard";
import { Link } from "react-router-dom";

const Example = (props) => {
  return (
    <div>
      <Card className="m-1">
        <Container className="themed-container">
          <Row className="pr-4 pl-4">
            <div className="d-flex justify-content-between w-100">
              <h4>Action</h4>
              <Link to="/movie/action">View All</Link>
            </div>
          </Row>
          <Row xs="4" className="mb-4">
            <Col>
              <ImageCard />
            </Col>
            <Col>
              <ImageCard />
            </Col>
            <Col>
              <ImageCard />
            </Col>
            <Col>
              <ImageCard />
            </Col>
          </Row>
        </Container>
      </Card>
    </div>
  );
};

export default Example;

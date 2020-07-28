import React from "react";
import movieImage from "../../img/movie.jpg";
import {
  Card,
  CardBody,
  CardTitle,
  CardSubtitle,
  CardText,
  CardLink,
} from "reactstrap";
import { Link } from "react-router-dom";
export default function ImageCard() {
  return (
    <div>
      <Link to="/title/123">
        <Card>
          <img width="100%" src={movieImage} alt="Card image cap" />
          {/* <CardBody>
          <CardText>Sons of Anarchy</CardText>
        </CardBody> */}
          <CardTitle className="text-center">Special Title Treatment</CardTitle>
        </Card>
      </Link>
    </div>
  );
}

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
export default function ImageCard(props) {
  console.log(props);
  return (
    <div>
      <Link to={`/title/${props.movie.id}`}>
        <Card>
          <img
            width="100%"
            src={`data:image/jpeg;base64,${props.movie.image}`}
            alt="Card image cap"
          />
          {/* <CardBody>
          <CardText>Sons of Anarchy</CardText>
        </CardBody> */}
          <CardTitle className="text-center">{props.movie.title}</CardTitle>
        </Card>
      </Link>
    </div>
  );
}

import React from 'react'

import Reveal from 'react-reveal/Reveal';

const LinksList = props => {
  const { items } = props;
  // const classes = 'animatable link dim db text-gradient-clip bb b--black-10';
  const classes = 'animatable link dim db text-gradient-clip bb b--light-gray';

  if (!items || !items.map) {
    return null;
  }

  return (
    <div className="f3 fw2">
      <Reveal effect="slideUp" cascade>
        {
          items.map( (l, i) =>
            <a
              className={`${classes} bg-gradient-${i+1} pv4`}
              target="_blank"
              rel="noopener noreferrer"
              href={l.url}
              key={l.label}
            >
              {l.label} 
            </a>
          )
        }
      </Reveal>
    </div>
  )
}

export default LinksList
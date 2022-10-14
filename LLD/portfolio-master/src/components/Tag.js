import React from 'react'

const Tag = (props) => {
    let classes = 'br2 ba b--moon-gray gray dib ';
    // let classes = "br2 ba b--light-gray dark-gray f7 mr2 mt2 pa1";

    if (props.size && props.size === 'big') {
        classes += 'f5 mr2 mb2 pv1 ph2';
    } else {
        classes += 'f7 mr2 mb2 pv0 ph1';
    }

    return (
        <span className={classes}>
            {props.children}
        </span>
    );
}

export default Tag

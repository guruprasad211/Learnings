import React from 'react'

import Reveal from 'react-reveal/Reveal';

const Speaking = () => (
  <Reveal effect="slideUp">
      <Talk
        title="Protótipos (or: A Presentation About Prototypes Made As A Prototype)."
        context="Laboratório de Práticas Criativas em Software - UFRGS, Especialização em Engenharia de Software e Inovação, 2020"
        link="https://www.figma.com/proto/wzuas1ACN5n2t9lVyPtnj8/Apresenta%C3%A7%C3%A3o-Prot%C3%B3tipos?node-id=1%3A89&scaling=min-zoom"
      />

      <Talk
        title="Os 3 Pilares Para Escalar Design na VTEX"
        context="Design at Scale Meetup - Rio de Janeiro & Recife, 2019"
        link="https://www.youtube.com/watch?v=43S4BThGopU"
      />

      <Talk
        title="Gerando insights a partir de dados em produtos B2B complexos"
        context="TheDevelopersConference - Trilha Gestão de Produto. São Paulo 
        & Recife, 2019"
        link="https://docs.google.com/presentation/d/1xDkUiYvJFdY7QShe36kS9pauHzZJhRYnTLz0LNtZ2EY/edit?usp=sharing"
      />

      <Talk
        title="Uma nova experiência para criar e gerenciar promoções na VTEX"
        context="VTEX Day - São Paulo, 2019"
        link="https://docs.google.com/presentation/d/1eXlEMlTrrYifJIOIWkdEAiz_Pxo0iHnuXr_NhLsjQto/edit?usp=sharing"
      />

      <Talk
        title="A UX da Mobilidade Urbana - Cidades melhores para pedalar e viver"
        context="Interaction Latin America - Rio de Janeiro, 2018"
        link="https://docs.google.com/presentation/d/1wYfnc6qrscQ26ndJRMlrk82xW-tqHEZpuK_kVjXSofs/edit?usp=sharing"
      />

      {/* <Talk
        title="Rage, rage against the dying of the Design System - Morte e vida de um sistema para empoderar um ecossistema."
        context="Interaction Latin America, 2018 [proposal]"
        link="https://drive.google.com/open?id=10VxokY3c1onxm67WUD_flPh5tlxyydBy"
      /> */}

      <Talk
        title="É possível estacionar a bike de boa?"
        context="Bicicultura - Rio de Janeiro, 2018"
        link="https://docs.google.com/presentation/d/1JJvtK1kPmfCg-g06vtmPoQNBgT9BdHZQCGxbXaqZAm8/edit#slide=id.p"
      />

      {/* <Talk
        title="Podcasts"
        context="Isobar Lightning Talks - Porto Alegre, 2017"
        link="https://docs.google.com/presentation/d/1hzKk7USBEVX9m8HlrZD5rRb8sp-VXWFYuyebHe5kzJ8/edit?usp=sharing"
      /> */}

      <Talk
        title="Multimídias Livres"
        context="Fórum Internacional Software Livre - Porto Alegre, 2016"
        link="https://musica-libre.org/sprint_multimedia_2016_1"
      />

      <Talk
        title="O primeiro web app PWA para ciclistas"
        context="Google IO Extended - Porto Alegre, 2015"
        link="https://docs.google.com/presentation/d/18DyziybC2Benf43OMAd5T7611QULd9oWA1L60rzvrsM/edit#slide=id.p"
      />

      <Talk
        title="React no Mundo Real - Relatos do maior site de aluguel de carros do mundo"
        context="React Meetup - Porto Alegre, 2014"
        link="https://docs.google.com/presentation/d/1RnbQ5beTuvtUFzk6KX3kJXrF25i2WN-ZMcXbhlelktw/edit#slide=id.p"
      />

      {/* <Talk
        title="Slow TV"
        context="Isobar Lightning Talks, 2016"
        link="https://www.youtube.com/playlist?list=PLEQfAlS3xFFXkBT0lAzsiHvX1OKuH1qv5"
      />

      <Talk
        title="Fallacies"
        context="Isobar Lightning Talks, 2016"
        link="https://docs.google.com/presentation/d/1989zLiju0njGpa4oTJz3J80kEIODHYTTTfmP6UYX35M/edit#slide=id.p"
      /> */}

      {/* <Talk
        title="O que aprendi com as Artes Marciais"
        context="Desconferência UFRGS - Porto Alegre, 2013"
        link="https://docs.google.com/presentation/d/1djDV4rN1B3gyP-ODDjxwNMGlvgfExUyxe47l8n7tI_w/edit#slide=id.p"
      /> */}
    </Reveal>
)

class Talk extends React.Component {
  state = {
    hover: false
  }

  render() {
    const { title, context, link } = this.props;

    return (
      <a
        className={`link dark-gray animatable db pv4-ns pv3 lh-copy bb b--light-gray flex justify-between ${this.state.hover ? '' : ''}`}
        href={link}
        target="_blank"
        rel="noopener noreferrer"
        onMouseEnter={() => this.setState({hover: true})}
        onMouseLeave={() => this.setState({hover: false})}
      >
        <div className="">
          <div className="fw6 mv1">
            {title}
          </div>
          
          <div className="gray f5">
            {context}
          </div>
          
          {/* <div className="mv2">
            <a className="pretty-link" href={link}>
            Slides
            </a>
          </div> */}
        </div>

        <span className={`mt1 ${this.state.hover ? 'o-100' : 'o-0'}`}>
          ↗
        </span>
      </a>
    )
  }
}

export default Speaking
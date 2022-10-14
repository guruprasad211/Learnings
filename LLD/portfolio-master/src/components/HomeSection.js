import React from 'react'

class HomeSection extends React.Component {
    render() {
        const { title, description, children, fullScreen } = this.props;
        const anchor = title.toLowerCase();

        // const containerClasses = `${fullScreen && 'bg-near-white nl4-ns nr4-ns'}`;
        const containerClasses = 'mv7-ns mv4 ';

        const descriptionContent = (
            description &&
            <p className="f4-ns f5 fw5 pr4-ns mb5-ns mb4 mt0-ns mt0 lh-copy measure gray">
                {description}
            </p>
        );

        return (
            <section id={anchor} className={`mv7-ns mv4 ${fullScreen ? '' : 'flex-ns w-100'}`}>
                <div className={`flex flex-column ${fullScreen ? 'w-100' : 'w-50-ns'}`}>
                    <h2 className="f1-ns f2 lh-solid fw4 mv2-ns mb2 dark-gray left-3-ns tracked-tight">{title}</h2>
                    
                    <div className="left-3-ns mt2">
                        { descriptionContent }
                    </div>
                </div>

                <div className={`mb4 flex flex-row-ns flex-column items-top ${fullScreen ? 'w-100' : 'w-50-ns'}`}>
                    {
                        fullScreen ?
                            <div className='w-100'>
                                {children}
                            </div>
                            :
                            <div className='f5 mt0 w-100'>
                                { children }
                            </div>
                    }
                </div>
            </section>
        )
    };
};

export default HomeSection
